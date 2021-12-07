package edu.soft2.servlet;

import edu.soft2.dao.impl.NewsDaoImpl;
import edu.soft2.pojo.News;
import edu.soft2.tools.Page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PageControlServlet", value = "/PageControlServlet")
public class PageControlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Page pages = new Page();//创建Page对象
            NewsDaoImpl newsDao = new NewsDaoImpl();//创建NewsDao对象(若有service层，应创建NewsService对象)
            String pageIndex = request.getParameter("pageIndex");//获取url地址栏中的参数
            if (pageIndex == null) {//如第一次进入此servlet，无此参数，则设置为1，即第一页
                pageIndex = "1";
            }
            int currPageNo = Integer.parseInt(pageIndex);//当前页码
            if (currPageNo < 1) {//若小于第一页，则设置为第一页
                currPageNo = 1;
            }else if (currPageNo > pages.getTotalPageCount()) {//大于尾页，则设置为尾页
                //currPageNo = pages.getTotalPageCount();
            }
            pages.setCurrPageNo(currPageNo);//设置Page对象的属性---当前页码
            System.out.println("当前页="+currPageNo);
            int totalCount = newsDao.getTotalCount();//调用Dao层，获取News总记录条数
            System.out.println("totalCount="+totalCount);
            pages.setPageSize(2);//设置Page对象的属性---设置每页显示两条数据
            System.out.println("PageControlServlet.doGet，页面记录条数"+pages.getPageSize());
            pages.setTotalCount(totalCount);//设置Page对象的属性---设置总记录数
            pages.setTotalPageCount(pages.getTotalCount());//设置Page对象的属性---总页数
            System.out.println("总页数="+pages.getTotalCount());
            List<News> newsList = newsDao.getPageNewsList(pages.getCurrPageNo(),pages.getPageSize());//调用Dao层,获取newsList
            System.out.println("newsList"+newsList);
            pages.setNewsList(newsList);//设置Page对象的属性---newsList
            request.setAttribute("pages",pages);//Page的对象属性设置完毕后，将其存入request中
            System.out.println("pages="+pages);
            //response.sendRedirect("newspages/admin.jsp");
            request.getRequestDispatcher("newspages/admin.jsp").forward(request,response);//转发request到下页
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
