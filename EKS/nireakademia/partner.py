# -*- coding: utf-8 -*-
from odoo import fields, models

class Partner(models.Model):
    _inherit = 'res.partner'

    # Zutabe berria gehitu res.partner modeloan, t
    # defektuz partner bat ez da irakaslea
    irakaslea = fields.Boolean("Irakaslea", default=False)

    saio_idak = fields.Many2many('nireakademia.saioa',
        string="Emandako saioak", readonly=True)

