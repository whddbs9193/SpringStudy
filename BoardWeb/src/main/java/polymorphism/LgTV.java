package polymorphism;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component; //빈으로 등록

@Component("tv")
public class LgTV implements TV {
	//@Inject
	//@Autowired
	//@Qualifier("apple")
	//@Resource(name="sony")
	
	@Autowired
	private Speaker speaker;
	private int price;
	
	// 기본 생성자
	public LgTV() {
		System.out.println("=> LgTV(1) --- 객체 생성");
	}
	
	// 생성자 오버로딩
	public LgTV(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("=> LgTV(2) --- 객체 생성");
			
		}

	// 생성자 오버로딩 - Context 에서 넘어오는 변수값 받기
	public LgTV(Speaker speaker, int price) {
		this.speaker = speaker;
		this.price = price;
		System.out.println("=> LgTV(3) --- 객체 생성");
		}
	
	// setter
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("=> setSpeaker() 호출");
	}
	
	public void  setPrice(int price) {
		this.price = price;
		System.out.println("=> setPrice() 호출");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV --- 전원을 켠다 (가격: " + price +")");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV --- 전원을 끈다");
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
		//System.out.println("LgTV --- 소리를 올린다");
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
		//System.out.println("LgTV --- 소리를 내린다");
	}
}
