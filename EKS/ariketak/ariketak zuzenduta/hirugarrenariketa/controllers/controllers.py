# -*- coding: utf-8 -*-
# from odoo import http


# class Exercise2(http.Controller):
#     @http.route('/exercise2/exercise2', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/exercise2/exercise2/objects', auth='public')
#     def list(self, **kw):
#         return http.request.render('exercise2.listing', {
#             'root': '/exercise2/exercise2',
#             'objects': http.request.env['exercise2.exercise2'].search([]),
#         })

#     @http.route('/exercise2/exercise2/objects/<model("exercise2.exercise2"):obj>', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('exercise2.object', {
#             'object': obj
#         })

