# -*- coding: utf-8 -*-

from odoo import models, fields

class Erabiltzaileak(models.Model):
    _inherit = 'res.users'  # extendidu egiten dut resusersera

    telefonoa = fields.Char(string="Telefonoa")  # telefono kanpoa