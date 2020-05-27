

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.web_db;
import utils.DBUtil;

/**
 * Servlet implementation class m_serch02
 */
@WebServlet("/m_serch")
public class m_serch02 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public m_serch02() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String music_result = request.getParameter("music_result");
        EntityManager em = DBUtil.createEntityManager();
        List<web_db> web_dbs = em.createNamedQuery("getalllist",web_db.class).getResultList();
        long web_db_count = (long)em.createNamedQuery("checkar", Long.class).setParameter("music_result", music_result).getSingleResult();
        if(web_db_count < 1){
            web_db_count = (long)em.createNamedQuery("checksr", Long.class).setParameter("music_result", music_result).getSingleResult();
            if(web_db_count < 1){
                web_db_count = (long)em.createNamedQuery("checktu", Long.class).setParameter("music_result", music_result).getSingleResult();
                if(web_db_count < 1){
                    web_dbs = em.createNamedQuery("getlist",web_db.class).setParameter("music_result",music_result).getResultList();
                    web_db_count = (long)em.createNamedQuery("checklist",Long.class).setParameter("music_result", music_result).getSingleResult();
                }
            }
        }

        em.close();

        request.setAttribute("web_dbs", web_dbs);
        request.setAttribute("web_db_count",web_db_count);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/result_show.jsp");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
