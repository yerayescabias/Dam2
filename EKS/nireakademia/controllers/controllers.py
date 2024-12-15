# -*- coding: utf-8 -*-
from odoo import http

# class Nireakademia(http.Controller):
#     @http.route('/nireakademia/nireakademia/', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/nireakademia/nireakademia/objects/', auth='public')
#     def list(self, **kw):
#         return http.request.render('nireakademia.listing', {
#             'root': '/nireakademia/nireakademia',
#             'objects': http.request.env['nireakademia.nireakademia'].search([]),
#         })

#     @http.route('/nireakademia/nireakademia/objects/<model("nireakademia.nireakademia"):obj>/', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('nireakademia.object', {
#             'object': obj
#         })