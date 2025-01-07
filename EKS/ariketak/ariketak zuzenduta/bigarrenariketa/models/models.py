# -*- coding: utf-8 -*-

from odoo import models, fields, api

class Bigarrenariketa(models.Model):
    _name = 'bigarrenariketa'
    Erabiltzaile_id = fields.Many2one('res.users', string="user_id", ondelete='set null') # hau res.usersekin lotuko du
    izena = fields.Char(related='Erabiltzaile_id.name', string="erabiltzailea", store=True) 
    emaila = fields.Char(related='Erabiltzaile_id.email', string="Emaila", store=True)
    telefonoa = fields.Char(related='Erabiltzaile_id.phone', string="telefonoa", store=True)
