package cc.shinbi.java;


	
	//import宣言
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
	
	public class QUIZ {
	    public static void main(String args[]){

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
	      System.out.println(year + "年" + month + "月" + date + "日"
	                             +  hour + " 時 " + minute + " 分 " 
	                             + second + " 秒 " + youbi[day_week]);

	      System.out.println("------------------------------------------");
	      
	   // 処理前の時刻を取得
	        long startTime = System.currentTimeMillis();
	        
	        // 時間計測をしたい処理
	        int result = 0;
	        for (int i = 0; i < 1000000; i++) {
	            result += 1;
	        }

	    
		try{	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	String str[][] = {
			{"問題1 大島さんが好きな季節は？",
				"1.春","2.夏","3.秋","4.冬","2"
			},
			{"問題2 砂岡さんが好きな季節は？",
				"1.春","2.夏","3.秋","4.冬","3"
			},
			{"問題3 坪井さんが好きな季節は？",
				"1.春","2.夏","3.秋","4.冬","1"
			},
			{"問題4 小田さんが好きな季節は？",
				"1.春","2.夏","3.秋","4.冬","4"
			},
			{"問題5 田中先生が好きな季節は？",
				"1.春","2.夏","3.秋","4.冬","2"}}; 
	 
	        System.out.println("＜＜＜４択クイズの開始です  5問あります。＞＞＞");

	        int count = 0;
	      for(int i = 0; i< str.length;i++){  

	      System.out.println(str[i][0]);
	      System.out.println(str[i][1]);
	      System.out.println(str[i][2]);
	      System.out.println(str[i][3]); 
	      System.out.println(str[i][4]); 

	      System.out.println("クイズの答えは？");
	       String str1 = br.readLine();
	      int in = Integer.parseInt(str1);
	 
	        String str2 = str[i][5];
	         int in1 = Integer.parseInt(str2);

	        if(in == in1){
	  System.out.println("");
	  System.out.println("！！！  大正解です   ！！！");
	  System.out.println("");   

	      count++;

	       }else if(in > 4){    System.out.println("");
	     System.out.println("1 から 4の数字で答えてください");
	     System.out.println("");    i--;
	  }else{
	  System.out.println("");
	  System.out.println("・・・   残念！はずれです   ・・・");
	  System.out.println("");
	      }
	       
	        
	  }
	      // 処理後の時刻を取得
	      long endTime = System.currentTimeMillis(); 
	      
	     switch(count){

	    case 0: System.out.println("あなたの得点  ： 0点"); break;
	    case 1: System.out.println("あなたの得点  ： 1点"); break;
	    case 2: System.out.println("あなたの得点  ： 2点"); break;
	    case 3: System.out.println("あなたの得点  ： 3点"); break;
	    case 4: System.out.println("あなたの得点  ： 4点"); break;
	    case 5: System.out.println("あなたの得点  ： 5点"); break;
	    
	  }
	     
	     float totaltime =  (endTime - startTime);
	     System.out.println("回答完了までの時間：" + totaltime/1000 + "sec");
		
	     
	     
		 if(totaltime < 10000) {
			 System.out.println("10秒以下のあなたへスペシャルボーナス！！　100点を加算します!!" );
			 System.out.println("あなたの得点は" + (100 + count) + "点です。");
		 }
		 else if(totaltime > 20000) {
			 System.out.println("回答に時間がかかりすぎです・・・得点を没収します!!" );
			 System.out.println("あなたの得点は" + (count - count) + "点です。");
		 }else {
			 System.out.println("お疲れ様でした！" );
		 }
			 
	     
	     
	 }catch(IOException e){
	  System.out.println("Exception: " + e);
	  
	  
	  }
	  catch(NumberFormatException e){
	  
	  System.out.println("数字を入力してください");
	         }
	    }

	}




