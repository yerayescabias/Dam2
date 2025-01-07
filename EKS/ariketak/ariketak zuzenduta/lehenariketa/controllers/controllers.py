# -*- coding: utf-8 -*-
# from odoo import http


# class Lehenariketa(http.Controller):
#     @http.route('/lehenariketa/lehenariketa', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/lehenariketa/lehenariketa/objects', auth='public')
#     def list(self, **kw):
#         return http.request.render('lehenariketa.listing', {
#             'root': '/lehenariketa/lehenariketa',
#             'objects': http.request.env['lehenariketa.lehenariketa'].search([]),
#         })

#     @http.route('/lehenariketa/lehenariketa/objects/<model("lehenariketa.lehenariketa"):obj>', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('lehenariketa.object', {
#             'object': obj
#         })

