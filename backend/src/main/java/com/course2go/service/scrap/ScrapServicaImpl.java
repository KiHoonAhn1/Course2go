package com.course2go.service.scrap;

import org.springframework.stereotype.Service;

@Service
public class ScrapServicaImpl implements ScrapService {

	@Override
	public boolean scrap(String uid, Integer bid) {
		/*스크랩 하기*/
		/*알림 생성하기*/
		return false;
	}

	@Override
	public boolean cancelScrap(String uid, Integer bid) {
		/*스크랩 취소하기*/
		return false;
	}
}
