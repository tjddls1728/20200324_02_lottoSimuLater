package kr.co.a20200324_02_lottosimulater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import kr.co.a20200324_02_lottosimulater.databinding.ActivityMainBinding;

public class MainActivity extends baseActivity {

    List<TextView> winNumTxtList = new ArrayList<>();
    int[] winLottoNumArr = new int[6];
    int bonusNum = 0;

    ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupEvents();
        setupValues();

    }

    @Override
    public void setupEvents() {

        binding.buyOneLottoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeWinLottoNum();

//                당첨번호 생성 => 텍스트뷰에 반영.

            }
        });

    }

    @Override
    public void setupValues() {

        winNumTxtList.add(binding.winLottoNumTxt01);
        winNumTxtList.add(binding.winLottoNumTxt02);
        winNumTxtList.add(binding.winLottoNumTxt03);
        winNumTxtList.add(binding.winLottoNumTxt04);
        winNumTxtList.add(binding.winLottoNumTxt05);
        winNumTxtList.add(binding.winLottoNumTxt06);



    }
    void makeWinLottoNum(){

//        6개의 숫자 (배열) + 보너스번호 1개 int 변수
//         => 이 함수에서만이 아니라, 다른곳에서도 쓸 예정.
//         => 당첨 등수 확인떄도 사용.=> 멤버변수로 배열 / 변수 생성

//      당첨번호 + 보너스 번호 모두 0으로 초기화.
//        (이미 뽑은 번호가 있다면 모두 날리자)

        for (int i=0; i<winLottoNumArr.length; i++){
            winLottoNumArr[i] = 0;
        }
        bonusNum = 0;

//        로또번호 6개 생성.
//        1~45여야 함 + 중복 허용 X.

        for (int i=0; i<winLottoNumArr.length; i++){
//            1~45의 숫자를 랜덤으로 뽑고
//            중복이 아니라면 => 당첨번호로 선정
//            중복이라면? -> 다시 뽑자. => 중복이 아닐때까지 계속 뽑자.

            while (true){

//                1 <= (int) (Math.random()*45+1) < 46

//                1~45의 정수를 랜덤으로 뽑아서 임시저장.
//                이 숫자가 중복검사를 통과하면 사용, 아니면 다시
               int randomNum = (int) (Math.random()*45+1);

//               중복검사? 당첨번호 전부와 randomNum을 비교.
//                하나라도 같으면 탈락.
                boolean isDup1Ok = true; //중복검사 변수

                for (int winNum : winLottoNumArr){

                    if (winNum == randomNum){
                        isDup1Ok = false;//탈락처리
                        break;
                    }

                }
                if (isDup1Ok){
                    winLottoNumArr[i]=randomNum;
                    Log.i("당첨번호",randomNum+"");
                    break; //무한반복 탈출
                }


            }

        }

//        6개의 당첨번호를 작은 숫자부터 정렬.
        Arrays.sort(winLottoNumArr);

        for (int i=0 ; i<winLottoNumArr.length ; i++) {


            winNumTxtList.get(i).setText(winLottoNumArr[i]+"");
        }


    }
}
