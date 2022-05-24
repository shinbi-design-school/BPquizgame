package cc.shinbi.Quiz;
	
	import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/QuizQuestion1")
public class QuizQuestion1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public QuizQuestion1() {
        super();

    }
	
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  //protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    //日付を格納する変数を作成
	       int year,month,date,hour,minute,second,day_week;

	    //曜日表示用に、曜日文字列を格納する配列の作成
	      String youbi[] = {"日曜日","月曜日","火曜日",
	                        "水曜日","木曜日","金曜日","土曜日"};


	   //Calendarオブジェクトの取得
	     Calendar now = Calendar.getInstance();

	       year = now.get(Calendar.YEAR);
	       month = now.get(Calendar.MONTH);
	       date = now.get(Calendar.DATE);
	       hour = now.get(Calendar.HOUR);
	       minute = now.get(Calendar.MINUTE);
	       second = now.get(Calendar.SECOND);
	       day_week = now.get(Calendar.DAY_OF_WEEK) - 1;


	   //日付を出力

	      String Date = (year + "年" + month + "月" + date + "日"
	                          +  hour + " 時 " + minute + " 分 " 
	                          + second + " 秒 " + youbi[day_week]);
	      
	      
	      HttpSession session = request.getSession();//iの情報をいったんセッションに保管し、下の方の次のページを開くときの条件として渡してやる
	      session.setAttribute("Date", Date);//クイズを実施した日時をセッションに保存

	      //System.out.println("------------------------------------------------------");
	      
	      
	    
		try{ 
			
		
			 
		     int tokuten = 0;
		     long startTime = 0;
		     long endTime = 0;
		     //int i =0;
		     //String Q1 = request.getParameter("Q1");
		     //String Q2 = request.getParameter("Q2");
		     //String Q3 = request.getParameter("Q3");
		     //String Q4 = request.getParameter("Q4");
		     //String Q5 = request.getParameter("Q5");
		     
		     String next = request.getParameter("next");
		     
		     int i = (int)session.getAttribute("i");//前の問題でiを保存しているのでそれを呼び出す。
		     int tokutentotal = (int) session.getAttribute("tokutentotal"); 
		 	 int count = (int) session.getAttribute("count"); 
		     
		     //int tokutentotal = 0;
		     //int count = 0;
		     
		     

		      
		   //HttpSession session = request.getSession();//iの情報をいったんセッションに保管し、下の方の次のページを開くときの条件として渡してやる
		      
		     
		     //if(Q1 != null) {
		    	 //i=0;
		    	 //session.setAttribute("i", 0);//条件ごとに格納する情報を変えてif式で記載	
		     //}else if(Q2 != null) {
		    	 //i=1;
		    	 //session.setAttribute("i", 1);	
		     //}else if(Q3 != null) {
		    	 //i=2;
		    	 //session.setAttribute("i", 2);	
		     //}else if(Q4 != null) {
		    	 //i=3;
		    	 //session.setAttribute("i", 3);	
		     //}else if(Q5 != null) {
		    	 //i=4;
		    	 //session.setAttribute("i", 4);	
		     //}
			
			
		     
		    
			
			
			//サーブレットコンテキストの取得
			ServletContext sc = getServletContext();
			
		
			
			
	    
			String str[][] = {
			{"問題1 大島さんが好きな季節は？",
				"1.春","2.夏","3.秋","4.冬","2"
			},
			{"問題2 砂岡さんが好きな色は？",
				"1.白","2.赤","3.黒","4.青","3"
			},
			{"問題3 坪井さんが好きな動物は？",
				"1.犬","2.猫","3.馬","4.羊","1"
			},
			{"問題4 小田さんが好きな地域は？",
				"1.春","2.夏","3.秋","4.冬","4"
			},
			{"問題5 田中先生が好きな季節は？",
				"1.春","2.夏","3.秋","4.冬","2"}}; 
	 


	
	
	        //System.out.println("＜＜＜４択クイズの開始です  5問あります。＞＞＞");
	        


	       
	   // for(i = 0; i< str.length;i++){  

			
		String question = (str[i][0]);
		String answer1 = (str[i][1]);
		String answer2 = (str[i][2]);
		String answer3 = (str[i][3]); 
		String answer4 = (str[i][4]); 
		String correct= (str[i][5]); 
			
	      System.out.println(str[i][0]);
	      System.out.println(str[i][1]);
	      System.out.println(str[i][2]);
	      System.out.println(str[i][3]); 
	      System.out.println(str[i][4]);
	      
	      
	   // 処理前の時刻を取得
	      
		    //startTime1 = System.currentTimeMillis();//この処理で時間カウントスタート。
		    
		    // 時間計測をしたい処理。
		    //int result1 = 0;
		    //for (int i1 = 0; i1 < 1000000; i1++) {
		        //result1 += 1;
		    //}
	     
	      
		     

	      System.out.println("クイズの答えは？");
	      
	    //フォームデータ取得
			//String str1 = request.getParameter("answer");
			
			String str1;
			int in =0;
			
				if(request.getParameter("1") != null) {
					str1 =request.getParameter("1");
					in = Integer.parseInt(str1);
				}else if(request.getParameter("2") != null) {
					str1 =request.getParameter("2");
					in = Integer.parseInt(str1);
				}else if(request.getParameter("3") != null) {
					str1 =request.getParameter("3");
					in = Integer.parseInt(str1);
				}else if(request.getParameter("4") != null) {
					str1 =request.getParameter("4");
					in = Integer.parseInt(str1);
				}
				
				

				
			
			System.out.println("回答：" + in);
			
		
	      
	       //String str1 = br.readLine();//コンソール上にて答えをキー入力させる処理。実際にはボタンになるので、修正が必要。
	       //in = Integer.parseInt(str1);//入力値を整数に変換し、inに代入。
	 
	       String str2 = str[i][5];//iには各問題No,が代入され、”String str[][] = {”で入力された5つ目の条件＝答えを呼び出してやる。
	       int in1 = Integer.parseInt(str2);//入力値を整数に変換し、in1に代入。
	       System.out.println("答え：" + in1);
	       //session.setAttribute("in1", in1);
	       
	         
	      // 処理後の時刻を取得
		     endTime = System.currentTimeMillis(); //この処理で、回答時間を確定
		  // 各質問でかかった時間を表示
		      //float totaltime1 =  (endTime1 - startTime1);
		      
		      //session.setAttribute("endTime", endTime);//クイズ回答した時の時間を記録し、セッションに保存
		      
		      startTime =  (long) session.getAttribute("startTime");//QuizResultで計測したstartTimeを入手する。
		      
		      
		      float answertime =  (endTime - startTime);//endTime と startTimeの差からかかった時間を計算してやる。
		      
		      
		      

		      int no = i+1;//問題No,を生じさせるための処理+1を加えることで、問題文と一致させる。
	         
	      if(answertime >= 10000) {//10秒以上は無効にしたいのでこの処理を追加。
	    	  
	    	  	sc.getRequestDispatcher("/timeover.jsp").forward(request,  response);
	    	  
	    	  	System.out.println("時間切れです");
	      }
	      else if(in == in1 && answertime < 10000) {//正解だった時の残り時間のボーナス得点を算出する。
	    	  
	    	  	tokuten = (10-((int)answertime/1000));//制限時間10secなので、10secからかかった時間を差し引き、残り時間を求める。
	    	  	
	    	  	session.setAttribute("answertime", answertime);//時間情報をcorrect.jspに渡す。
	    	  	session.setAttribute("tokuten", tokuten);//得点情報をcorrect.jspに渡す。
	    	  	
	    	  	count++;//各質問の獲得得点を足していくための処理。
	    	  	session.setAttribute("count", count);
	    	  	tokutentotal += tokuten; //最終的にトータルのボーナス得点を求める必要があるので、この式を入れて、加算させる。
	    	  	session.setAttribute("tokutentotal", tokutentotal);
	    	  	
	    	  	System.out.println("！！！  大正解です。得点10点を獲得しました！！！");
	      		System.out.println("問題" + no + "の回答までの時間：" + answertime/1000 + "sec");
	      		System.out.println("残り時間ボーナス：" + tokuten  + "点が加算されます！"); 
			    
			    //Thread.sleep(100);//answertimeをincorrect.jspが取り出すまでにもし必要であればsleepを入れる。
			    sc.getRequestDispatcher("/correct.jsp").forward(request,  response);//上の行の処理が終わってからページを開くようにする必要があるので、この行は最後に持ってくる（次のページが情報を取れなくてエラーになる）

	      }
	      else if(in == in1){//正解だった場合の処理
	      		
	      		session.setAttribute("answertime", answertime);//時間情報をcorrect.jspに渡す。
	      		
	      		count++;//各質問の獲得得点を足していくための処理。
	      		
	      		session.setAttribute("count", count);
	      		
	      		System.out.println("！！！  大正解です。得点10点を獲得しました！！！");
	      		System.out.println("問題" + no + "の回答までの時間：" + answertime/1000 + "sec");
	      		
	      		//Thread.sleep(100);//answertimeをincorrect.jspが取り出すまでにもし必要であればsleepを入れる。
	      		sc.getRequestDispatcher("/correct.jsp").forward(request,  response);//上の行の処理が終わってからページを開くようにする必要があるので、この行は最後に持ってくる（次のページが情報を取れなくてエラーになる）
	      }
	      else if(in != in1 && next == null) {//不正解だった場合の処理。
	    	  
	    	   	session.setAttribute("answertime", answertime);//時間情報をcorrect.jspに渡す。
	    	   
	    	   	System.out.println("・・・   残念！はずれです   ・・・");
	    	   	System.out.println("問題" + no + "の回答までの時間：" + answertime/1000 + "sec");

	    	   	//Thread.sleep(100);//answertimeをincorrect.jspが取り出すまでにもし必要であればsleepを入れる。
	    	   	sc.getRequestDispatcher("/incorrect.jsp").forward(request,  response);//上の行の処理が終わってからページを開くようにする必要があるので、この行は最後に持ってくる（次のページが情報を取れなくてエラーになる）
	      }   
	      
	      
	      i++;//次の問題に進むためにiに1を追加する。
	      session.setAttribute("i", i);//追加したiをセッションに保存する。
	      
	      
	      
	      //Thread.sleep(300);//計算の時間を確保するために保留(必要時に使う)
	      
	      count = (int)session.getAttribute("count");//動作確認のためにcount情報を入手
	      tokutentotal = (int)session.getAttribute("tokutentotal");//動作確認のためにcount情報を入手
	      i = (int)session.getAttribute("i");
	      
	      int  totalresult = (count*10) + tokutentotal;
	      
	      System.out.println("合計得点" + count*10);
	      System.out.println("総合得点" + totalresult);
	      System.out.println("更新したi：" + i);

	      
	      
	      //if(i == 4) {//最後の問題５の処理が終わったら、正解得点＋ボーナス得点の総合結果を求めて、”Quizresult”に送る
	    	  //totalresult = count + tokuten;//双方結果を求める
	    	  //session.setAttribute("totalresult", totalresult);//その結果を”Quizresult”、および、ご褒美画面に送るためのセッション保存
	    	  //session.setAttribute("count", count);//その結果をご褒美画面に送るためのセッション保存
	    	  
		      //System.out.println("得点" + count);
		      //System.out.println("総合得点" + totalresult);
	      //}
	      
	      
	      
	      //if(next != null && Q1 != null) {
	    	  //sc.getRequestDispatcher("/QuizQ2.jsp").forward(request,  response);
	      //}else if(next != null &&  i == 1) {
	    	  //sc.getRequestDispatcher("/QuizQ3.jsp").forward(request,  response);
	      //}else if(next != null &&  i == 2) {
	    	  //sc.getRequestDispatcher("/QuizQ4.jsp").forward(request,  response);
	      //}else if(next != null &&  i == 3) {
	    	  //sc.getRequestDispatcher("/QuizQ5.jsp").forward(request,  response);
	      //}else if(next != null &&  i == 4) {
	    	  //sc.getRequestDispatcher("/QuizQ1.jsp").forward(request,  response);
	      //}
	    	  	
	      
		      
		      
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

		




