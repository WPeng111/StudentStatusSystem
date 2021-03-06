package com.zb.servlet.Compulsory;

import com.google.gson.Gson;
import com.zb.dao.CompulsoryDao;
import com.zb.daoImpl.CompulsoryDaoImpl;
import com.zb.pojo.Sc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectFourthGrade")
public class SelectFourthGradeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("查询大四的成绩");
        int sno = Integer.parseInt(req.getParameter("sno"));
        System.out.println(sno);

        CompulsoryDao dao =new CompulsoryDaoImpl();
        List<Sc> list = dao.searchFourthSc(sno);

        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
        resp.getWriter().write(json);
    }
}
