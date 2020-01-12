
package beans;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import pojos.Articulospro;
import repositories.RepositoryGeneral;


public class BeanGeneral {
    RepositoryGeneral repo;
    
    
    public BeanGeneral(){
        this.repo = new RepositoryGeneral();
    }
    
    public String getArticulosDatalist(){
        List<Articulospro> art = repo.gettodosArticulos();
        String html = "";
        for (Articulospro artic: art){
            html += "<option value='" + artic.getNombre() + "'>";
        }
        return html;
    }
    
    public String getFoto1(int id){
        Articulospro art = repo.getOneArticle(id);
        String foto = art.getFoto1();
        return foto;
    }
}
