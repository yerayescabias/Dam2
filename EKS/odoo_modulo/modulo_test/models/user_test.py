from odoo import models, fields

class UserTest(models.Model):
    _name = 'user.test'
    _description = 'User Test'
    _table = 'user_test'

    user_id = fields.Many2one('res.users', string="Usuario", ondelete='set null')

    nombre = fields.Char(related='user_id.name', string="Nombre del Usuario", store=True)
    correo = fields.Char(related='user_id.email', string="Correo del Usuario", store=True)
    telefono = fields.Char(related='user_id.phone', string="Teléfono del Usuario", store=True)
