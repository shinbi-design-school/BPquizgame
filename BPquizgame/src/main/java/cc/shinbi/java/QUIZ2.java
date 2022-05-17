package cc.shinbi.java;


	
	//import宣言
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Scanner;
	
	public class QUIZ2 {
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
	      
	    //クイズ開始からすべて完了するまでの所要時間
	      //処理前の時刻を取得
	        //long startTime = System.currentTimeMillis();
	        
	        // 時間計測をしたい処理
	        //int result = 0;
	        //for (int i = 0; i < 1000000; i++) {
	            //result += 1;
	        //}
	    
		try{
			 
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	    
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
	        int tokuten = 0;
	        int tokutentotal = 0;
	      for(int i = 0; i< str.length;i++){  

	      System.out.println(str[i][0]);
	      System.out.println(str[i][1]);
	      System.out.println(str[i][2]);
	      System.out.println(str[i][3]); 
	      System.out.println(str[i][4]); 
	      
		     // 処理前の時刻を取得
			    long startTime1 = System.currentTimeMillis();
			    
			    // 時間計測をしたい処理
			    int result1 = 0;
			    for (int i1 = 0; i1 < 1000000; i1++) {
			        result1 += 1;
			    }

	      System.out.println("クイズの答えは？");
	       String str1 = br.readLine();
	      int in = Integer.parseInt(str1);
	 
	        String str2 = str[i][5];
	         int in1 = Integer.parseInt(str2);

	        if(in == in1){
	  System.out.println("");
	  System.out.println("！！！  大正解です。得点10点を獲得しました！！！");
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
	        
	     // 処理後の時刻を取得
		      long endTime1 = System.currentTimeMillis(); 
		      
		      int no = i+1;
		      
		      if(in < 5) {//入力エラーがあったときに問題の再表示があるが、if式を入れていないと前の問題の時間が表示されるので、それを防ぐために、入力値が正しいことを確認した上で表示させる
		      float totaltime1 =  (endTime1 - startTime1);//各質問でかかった時間を表示
			     System.out.println("問題：" + no + "の回答までの時間：" + totaltime1/1000 + "sec");
			     
			     if(in == in1) {//正解だった時の残り時間のボーナス得点を算出する。
			    	 tokuten = (10-((int)totaltime1/1000));//制限時間10secなので、10secからかかった時間を差し引き、残り時間を求める。
			    	 System.out.println("残り時間ボーナス：" + tokuten  + "点が加算されます！"); 
			    	 tokutentotal += tokuten; //最終的にトータルのボーナス得点を求める必要があるので、この式を入れて、加算させる。
			     }
		      }
			 

	        
	    	System.out.println("次に進む場合は、ENTERキーを押してください");
	    	Scanner scan = new Scanner(System.in);//この分を入れることで、enterが押されるまで一時停止する。
	    	scan.nextLine();
	    	
	    	
	        
	  }
	      // 処理後の時刻を取得
	      long endTime = System.currentTimeMillis(); 
	      
	     //switch(count){

	    //case 0: System.out.println("あなたの正解得点  ： 0点です"); break;
	    //case 1: System.out.println("あなたの正解得点  ： 10点です"); break;
	    //case 2: System.out.println("あなたの正解得点  ： 20点です"); break;
	    //case 3: System.out.println("あなたの正解得点  ： 30点です"); break;
	    //case 4: System.out.println("あなたの正解得点  ： 40点です"); break;
	    //case 5: System.out.println("あなたの正解得点  ： 50点です"); break;
	    
	  //}
	     
	     System.out.println("残り時間ボーナス合計：" + (count*10) + "点です");
	     System.out.println("残り時間ボーナス合計：" + tokutentotal + "点です");
	     System.out.println("総合得点は" + ((count*10) + tokutentotal) + "点です");
	     System.out.println("お疲れ様でした！！！" );
	     
	     
	     
	     
	     
	     //float totaltime =  (endTime - startTime);
	     //System.out.println("回答完了までの時間：" + totaltime/1000 + "sec");
		
	     
	     
		 //if(totaltime < 10000) {
			 //System.out.println("10秒以下のあなたへスペシャルボーナス！！　100点を加算します!!" );
			 //System.out.println("あなたの得点は" + (100 + count) + "点です。");
		 //}
		 //else if(totaltime > 20000) {
			// System.out.println("回答に時間がかかりすぎです・・・得点を没収します!!" );
			 //System.out.println("あなたの得点は" + (count - count) + "点です。");
		 //}else {
			 //System.out.println("お疲れ様でした！" );
		 //}
			 
	     
	     
	 }catch(IOException e){
	  System.out.println("Exception: " + e);
	  
	  
	  }
	  catch(NumberFormatException e){
	  
	  System.out.println("数字を入力してください");
	         }
		return;
	    }
		}

	




