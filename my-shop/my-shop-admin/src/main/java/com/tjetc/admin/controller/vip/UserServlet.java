package com.tjetc.admin.controller.vip;


//@WebServlet(urlPatterns = {"/user/page"})
//public class UserServlet extends HttpServlet {
//    UserService userService = new UserServiceImpl();
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String searchKey = req.getParameter("searchKey");
//        String strDraw = req.getParameter("draw");
//        String strStart = req.getParameter("start");
//        String strLength = req.getParameter("length");
//        int key = Integer.parseInt(searchKey);
//        int draw = Integer.parseInt(strDraw);
//        int start = Integer.parseInt(strStart);
//        int pageSize = Integer.parseInt(strLength);
//
//        //调用userService的page方法查询数据
//        AdminPageResult<User> result = userService.page(start, pageSize);
//
//        result.setDraw(draw);
//        String json = JSONObject.toJSONString(result);
//        resp.getWriter().write(json);
//
//    }
//}
