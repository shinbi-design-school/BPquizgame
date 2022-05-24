package cc.shinbi.Quiz;
	
	import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/QuizResult")
public class QuizResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public QuizResult() {
        super();

    }
	
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



	     
	    
		try{ 
			//String Q1 = null;
			//String Q2 = null; 
			//String Q3 = null; 
			//String Q4 = null; 
			//String Q5 = null; 
	
			int i =0;
		    long startTime = 0;
		    long endTime = 0;
		    int count = 0;
		    int tokuten = 0;
		    int tokutentotal = 0;
		   
		    String start = request.getParameter("start");
		    String next = request.getParameter("next");
		    String over = request.getParameter("over");
		     
		     
		     HttpSession session = request.getSession();//iの情報をいったんセッションに保管し、下の方の次のページを開くときの条件として渡してやる
		   
		     //サーブレットコンテキストの取得
				ServletContext sc = getServletContext();  
		     
		     if(start != null) {
		    	 count = 0;
		    	 session.setAttribute("count", count);//正解数（count）をリセットしてやる＞＞前の情報が残ると正確に計算できない
		    	 tokutentotal = 0;
		    	 session.setAttribute("tokutentotal", tokutentotal);//ボーナス得点合計（count）をリセットしてやる＞＞前の情報が残ると正確に計算できない
		    	 i = 0;
		    	 session.setAttribute("i", i);//試験問題変数のiをリセットしてやる。
		    	 sc.getRequestDispatcher("/QuizQ1.jsp").forward(request,  response);//iの変数を修正した後に、最初なのでQ1ページへダイレクトに表示
		     } else if(over != null){//タイムオーバーの時の処理。回答をスキップするのでiを追加する必要がある。
		    	 i = (int) session.getAttribute("i");//iの情報をセッションから呼び出す。
		    	 i++;//回答をスキップした分、iを追加してやる。
		    	 session.setAttribute("i", i);//そのiをセッションに保存する。
		     }else {
		    	 i = (int) session.getAttribute("i");//初期値は0になっているが、ここでiの情報をセッションに格納した情報へ書き換えてやる。 		    
		     }
		     	
			
	
				startTime = System.currentTimeMillis();//// 次の質問に移るときに"nextが送信されるので、それを時間カウントスタートに使う。
			     
				  
				
				
				     
				session.setAttribute("startTime", startTime);//スタートタイムをセッションに保存し、"QuizQuestion1"に渡す。
				
				
				int totalresult =0;
				
			
				
				tokutentotal = (int) session.getAttribute("tokutentotal"); 
				count = (int) session.getAttribute("count");
				totalresult = (count*10) + tokutentotal; 
				
				
				
				
				if((over != null || next != null) && i < 5 ) {//結果画面の次へを押した時の処理を指示してやる。最後の質問(i==4)が終わったらご褒美画面に飛ばすので、その条件を指示
			    	  sc.getRequestDispatcher("/QuizQ1.jsp").forward(request,  response);
				}else if((over != null || next != null) && i == 5 && totalresult >= 85) {
			    	  Thread.sleep(300);
			    	  sc.getRequestDispatcher("/totalresulttest1.jsp").forward(request,  response);
			    }else if((over != null || next != null) && i == 5 && totalresult >= 55) {
			    	  Thread.sleep(300);
			    	  sc.getRequestDispatcher("/totalresulttest2.jsp").forward(request,  response);
			    }else if((over != null || next != null) && i == 5 && totalresult < 55) {
			    	  Thread.sleep(300);
			    	  sc.getRequestDispatcher("/totalresulttest3.jsp").forward(request,  response);
			    }
				
				
			    	  /*
				     if(next != null && i == 0) {//セッションから得たiの情報に対してif式を使って条件ごとに処理を変更させる
				    	  sc.getRequestDispatcher("/QuizQ2.jsp").forward(request,  response);
				      }else if(next != null && i == 1) {
				    	  sc.getRequestDispatcher("/QuizQ3.jsp").forward(request,  response);
				      }else if(next != null && i == 2) {
				    	  sc.getRequestDispatcher("/QuizQ4.jsp").forward(request,  response);
				      }else if(next != null && i == 3) {
				    	  sc.getRequestDispatcher("/QuizQ5.jsp").forward(request,  response);
				      }else if(next != null && i == 4 && totalresult >= 85) {
				    	  Thread.sleep(300);
				    	  sc.getRequestDispatcher("/totalresulttest1.jsp").forward(request,  response);
				      }else if(next != null && i ==4 && totalresult >= 55) {
				    	  Thread.sleep(300);
				    	  sc.getRequestDispatcher("/totalresulttest2.jsp").forward(request,  response);
				      }else if(next != null && i ==4 && totalresult < 55) {
				    	  Thread.sleep(300);
				    	  sc.getRequestDispatcher("/totalresulttest3.jsp").forward(request,  response);
				      }
				     */
				
			/*    
	      if(next != null || over != null && i == 0) {//セッションから得たiの情報に対してif式を使って条件ごとに処理を変更させる
	    	  sc.getRequestDispatcher("/QuizQ2.jsp").forward(request,  response);
	      }else if(next != null || over != null && i == 1) {
	    	  sc.getRequestDispatcher("/QuizQ3.jsp").forward(request,  response);
	      }else if(next != null || over != null && i == 2) {
	    	  sc.getRequestDispatcher("/QuizQ4.jsp").forward(request,  response);
	      }else if(next != null || over != null && i == 3) {
	    	  sc.getRequestDispatcher("/QuizQ5.jsp").forward(request,  response);
	      }else if(next != null || over != null && i == 4) {
	    	  sc.getRequestDispatcher("/totalresulttest.jsp").forward(request,  response);
	      }
	    	*/
	      
	     
	      
	      
	      	
	     
	      
	      
	
		      
		      
		      //if(in < 5) {//入力エラーがあったときに問題の再表示があるが、if式を入れていないと前の問題の時間が表示されるので、それを防ぐために、入力値が正しいことを確認した上で表示させる

			    // System.out.println("問題" + no + "の回答までの時間：" + totaltime1/1000 + "sec");
			     
			     //if(in == in1 && totaltime1 < 10000) {//正解だった時の残り時間のボーナス得点を算出する。
			    	// tokuten = (10-((int)totaltime1/1000));//制限時間10secなので、10secからかかった時間を差し引き、残り時間を求める。
			    	 //System.out.println("残り時間ボーナス：" + tokuten  + "点が加算されます！"); 
			    	 //tokutentotal += tokuten; //最終的にトータルのボーナス得点を求める必要があるので、この式を入れて、加算させる。
			     
		      
		
		      

		    //System.out.println("------------------------------------------------------"); 
		    //System.out.println("次に進む場合は、「次に進む」ボタンを押してください");
		    //System.out.println("------------------------------------------------------");
		   
  
		}
	    	
		
		/*     
	  }
	      
	     System.out.println("======================================================");
	     System.out.println("正解得点合計：" + (count*10) + "点です");
	     System.out.println("残り時間ボーナス合計：" + tokutentotal + "点です");
	     System.out.println("総合得点は" + ((count*10) + tokutentotal) + "点です");
	     System.out.println("お疲れ様でした！！！" );
	     System.out.println("======================================================");
	     
	     
	     */
	     
	     
	    /* 
	   //リクエスト転送テスト
			if(str1 == 1) {//ユーザーが入力した場合にSample5.jpsへ転送する
				sc.getRequestDispatcher("/correct.jsp").forward(request, response);
				
			}
			else if(str1 == 2) {//ユーザーが入力した場合にSample5.jpsへ転送する
				sc.getRequestDispatcher("/incorrect.html").forward(request, response);
			}
			else if(str1 == 3) {//ユーザーが入力しなかった場合に、error.htmlへ転送する
				//response.sendRedirect("http://localhost:8080/Ylesson7/error.html");
				sc.getRequestDispatcher("/timeover.html").forward(request,  response);
			}
			else if(str1 == 4) {
				sc.getRequestDispatcher("/error.html").forward(request,  response);
			}
			else if(ans.length() ==0) {
				sc.getRequestDispatcher("/error.html").forward(request,  response);
			}
		}
		
		*/
		catch(Exception e) {
			e.printStackTrace();
		
		}
    }
}

	

			
	     
	     /*
	 }catch(IOException e){
	  System.out.println("Exception: " + e);
	  
	  
	  }
	  catch(NumberFormatException e){
	  
	  System.out.println("数字を入力してください");//数字以外の入力だった場合は強制終了で仮置き（実際にはボタン操作であり、この処理は必要ない）
	         }
		return;
	    }
		}
		*/

		




