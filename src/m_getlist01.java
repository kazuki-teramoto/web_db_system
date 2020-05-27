

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.artist;
import models.series;
import models.tune;
import utils.DBUtil;

/**
 * Servlet implementation class m_getlist01
 */
@WebServlet("/m_getlist")
public class m_getlist01 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public m_getlist01() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub		response.getWriter().append("Served at: ").append(request.getContextPath());
        request.setCharacterEncoding("UTF-8");
        String selectpull = request.getParameter("music_list");
        EntityManager em = DBUtil.createEntityManager();

        if(selectpull.equals("アーティスト名")){
            List<artist> web_dbar = em.createNamedQuery("getar",artist.class).getResultList();
            em.close();
            request.setAttribute("web_dbs", web_dbar);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/m_getlistar.jsp");
            rd.forward(request, response);
        }else if(selectpull.equals("曲調")){
            List<tune> web_dbtu = em.createNamedQuery("gettu",tune.class).getResultList();
            em.close();
            request.setAttribute("web_dbs", web_dbtu);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/m_getlistml.jsp");
            rd.forward(request, response);
        }else if(selectpull.equals("シリーズ名")){
            List<series> web_dbsr = em.createNamedQuery("getsr",series.class).getResultList();
            em.close();
            request.setAttribute("web_dbs", web_dbsr);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/m_getlistsr.jsp");
            rd.forward(request, response);
        }else if(selectpull.equals("曲名")){
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/m_getlistmn.jsp");
            rd.forward(request, response);
        }else if(selectpull.equals("制作日")){
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/m_getlistpd.jsp");
            rd.forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
