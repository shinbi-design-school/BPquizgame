package cc.shinbi.java;


	
	//import宣言
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Scanner;
	
	public class QUIZ3 {
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

	      System.out.println("------------------------------------------------------");
	      
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
	        long startTime1 = 0;
	        long endTime1 = 0;
	        int tokutentotal = 0;
	      for(int i = 0; i< str.length;i++){  

	      System.out.println(str[i][0]);
	      System.out.println(str[i][1]);
	      System.out.println(str[i][2]);
	      System.out.println(str[i][3]); 
	      System.out.println(str[i][4]); 
	      
		     // 処理前の時刻を取得
	      
			    startTime1 = System.currentTimeMillis();//この処理で時間カウントスタート。
			    
			    // 時間計測をしたい処理。
			    int result1 = 0;
			    for (int i1 = 0; i1 < 1000000; i1++) {
			        result1 += 1;
			    }

	      System.out.println("クイズの答えは？");
	      
	      
	       String str1 = br.readLine();//コンソール上にて答えをキー入力させる処理。実際にはボタンになるので、修正が必要。
	       int in = Integer.parseInt(str1);//入力値を整数に変換し、inに代入。
	 
	       String str2 = str[i][5];//iには各問題No,が代入され、”String str[][] = {”で入力された5つ目の条件＝答えを呼び出してやる。
	       int in1 = Integer.parseInt(str2);//入力値を整数に変換し、in1に代入。
	         
	      // 処理後の時刻を取得
		      endTime1 = System.currentTimeMillis(); //この処理で、回答時間を確定
		  // 各質問でかかった時間を表示
		      float totaltime1 =  (endTime1 - startTime1);

	         
	      if(totaltime1 >= 10000) {//10秒以上は無効にしたいのでこの処理を追加。
	    	  	System.out.println("------------------------------------------------------");
	    	  	System.out.println("時間切れです");
	      	}else if(in == in1){//正解だった場合の処理
	      		System.out.println("------------------------------------------------------");
	      		System.out.println("");
	      		System.out.println("！！！  大正解です。得点10点を獲得しました！！！");
	      		System.out.println("");   
	    	  
	      count++;//各質問の獲得得点を足していくための処理。

	       }else if(in > 4){//5以上の入力だった場合の処理。
	    	   System.out.println("------------------------------------------------------");
	    	   	System.out.println("");
	       		System.out.println("1 から 4の数字で答えてください");
	       		System.out.println("");    i--;
	       }else{//不正解だった場合の処理。
	    	   System.out.println("------------------------------------------------------");
	    	   System.out.println("");
	    	   System.out.println("・・・   残念！はずれです   ・・・");
	    	   System.out.println("");
	      }
	           
		      int no = i+1;//問題No,を生じさせるための処理+1を加えることで、問題文と一致させる。
		      
		      if(in < 5) {//入力エラーがあったときに問題の再表示があるが、if式を入れていないと前の問題の時間が表示されるので、それを防ぐために、入力値が正しいことを確認した上で表示させる

			     System.out.println("問題" + no + "の回答までの時間：" + totaltime1/1000 + "sec");
			     
			     if(in == in1 && totaltime1 < 10000) {//正解だった時の残り時間のボーナス得点を算出する。
			    	 tokuten = (10-((int)totaltime1/1000));//制限時間10secなので、10secからかかった時間を差し引き、残り時間を求める。
			    	 System.out.println("残り時間ボーナス：" + tokuten  + "点が加算されます！"); 
			    	 tokutentotal += tokuten; //最終的にトータルのボーナス得点を求める必要があるので、この式を入れて、加算させる。
			     }
		      }
			 

		    System.out.println("------------------------------------------------------"); 
		    System.out.println("次に進む場合は、ENTERキーを押してください");
		    System.out.println("------------------------------------------------------");
		    Scanner scan = new Scanner(System.in);//このコード（下の行含め）を入れることで、enterが押されるまで一時停止する。
	    	scan.nextLine();
	    	
	    	
	        
	  }
	      
	     System.out.println("======================================================");
	     System.out.println("正解得点合計：" + (count*10) + "点です");
	     System.out.println("残り時間ボーナス合計：" + tokutentotal + "点です");
	     System.out.println("総合得点は" + ((count*10) + tokutentotal) + "点です");
	     System.out.println("お疲れ様でした！！！" );
	     System.out.println("======================================================");
	     
	     
	 }catch(IOException e){
	  System.out.println("Exception: " + e);
	  
	  
	  }
	  catch(NumberFormatException e){
	  
	  System.out.println("数字を入力してください");//数字以外の入力だった場合は強制終了で仮置き（実際にはボタン操作であり、この処理は必要ない）
	         }
		return;
	    }
		}

	




