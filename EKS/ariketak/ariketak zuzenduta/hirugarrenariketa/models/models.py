from odoo import models, fields

class IzenaUrtea(models.Model):
    _name = 'ariketa3'
    _description = 'ariketa3'

    izena = fields.Char(string="Izena")  
    urtea = fields.Integer(string="Urtea") 