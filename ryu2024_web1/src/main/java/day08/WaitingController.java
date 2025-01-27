package day08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/day08/waiting")
public class WaitingController extends HttpServlet {

	private ArrayList<HashMap<String, String>> list = new ArrayList<>();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		HttpSession session = req.getSession();
		HashMap<String, String> map = mapper.readValue(req.getReader(), HashMap.class);
		System.out.println(map);

		list.add(map);
		resp.setContentType("application/json");
		resp.getWriter().print(true);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(list); // List Map 를 JSON 문자열 변환
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String wNum = req.getParameter("wNum");
        if (wNum != null) {
           
            //list.removeIf(map -> wNum.equals(map.get("wNum")));

        }
     
        resp.setContentType("application/json");
        resp.getWriter().print(true);

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String wNum = req.getParameter("wNum");
		ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> updateMap = mapper.readValue(req.getReader(), HashMap.class);
        
        String updatePhoneNum = updateMap.get("phoneNum");
        String updatePNum = updateMap.get("pNum");
        
        if(wNum!=null) {
        	 for(String key : updateMap.keySet()) {
        		 if(updateMap.keySet("wNum")==wNum)
             	updateMap.put("phoneNum", updatePhoneNum);
             	updateMap.put("pNum", updatePNum);
             }
        }
      
        resp.setContentType("application/json");
        resp.getWriter().print(updateMap.values());
        }
	
}
