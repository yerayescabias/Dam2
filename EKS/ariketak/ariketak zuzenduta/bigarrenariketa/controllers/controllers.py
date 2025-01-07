# -*- coding: utf-8 -*-
# from odoo import http


# class Bigarrenariketa(http.Controller):
#     @http.route('/bigarrenariketa/bigarrenariketa', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/bigarrenariketa/bigarrenariketa/objects', auth='public')
#     def list(self, **kw):
#         return http.request.render('bigarrenariketa.listing', {
#             'root': '/bigarrenariketa/bigarrenariketa',
#             'objects': http.request.env['bigarrenariketa.bigarrenariketa'].search([]),
#         })

#     @http.route('/bigarrenariketa/bigarrenariketa/objects/<model("bigarrenariketa.bigarrenariketa"):obj>', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('bigarrenariketa.object', {
#             'object': obj
#         })

