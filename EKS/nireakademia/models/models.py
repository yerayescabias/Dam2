from odoo import models, fields, api

class Kurtsoa(models.Model):
    _name = 'nireakademia.kurtsoa'

    name = fields.Char(string="Izena", required=True)
    deskribapena = fields.Text()

    arduradun_id = fields.Many2one('res.users',
        ondelete='set null', string="Arduraduna", index=True)
    saio_idak = fields.One2many(
        'nireakademia.saioa', 'kurtsoa_id', string="Saioak")


class Saioa(models.Model):
    _name = 'nireakademia.saioa'

    name = fields.Char(required=True)
    hasiera_data = fields.Date(default=fields.Date.today)
    iraupena = fields.Float(digits=(6, 2), help="Iraupena egunetan")
    ikasleak = fields.Integer(string="Ikasle kopurua")
    aktibo = fields.Boolean(default=True)

    irakaslea_id = fields.Many2one('res.partner', string="Irakaslea",
                                   domain=['|', ('irakaslea', '=', True),
                                           ('category_id.name', 'ilike', "Monitorea")])

    kurtsoa_id = fields.Many2one('nireakademia.kurtsoa',
                                ondelete='cascade', string="Kurtsoa", required=True)
    ikasle_idak = fields.Many2many('res.partner', string="Ikasleak")

    bertaratutako_ikasleak = fields.Float(string="Bertaratutako ikasleak", compute='_bertaratuak')

    @api.depends('ikasleak', 'ikasle_idak')
    def _bertaratuak(self):
        for r in self:
            if not r.ikasleak:
                r.bertaratutako_ikasleak = 0.0
            else:
                r.bertaratutako_ikasleak = 100.0 * len(r.ikasle_idak) / r.ikasleak
