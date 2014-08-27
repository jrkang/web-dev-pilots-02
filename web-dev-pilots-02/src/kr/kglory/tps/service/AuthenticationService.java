package kr.kglory.tps.service;

import javax.servlet.http.HttpSession;

import kr.kglory.tps.common.exception.BaseException;
import kr.kglory.tps.common.filter.SessionObject;
import kr.kglory.tps.common.filter.TokenObject;
import kr.kglory.tps.mapper.AccountMapper;
import kr.kglory.tps.model.CommonBean.ReturnType;
import kr.kglory.tps.model.dto.LoginFormDto;
import kr.kglory.tps.model.vo.AccountVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	private static final Logger	logger	= LoggerFactory.getLogger(AuthenticationService.class);
	
	@Autowired
	MessageSource				messageSource;
	@Autowired
	AccountMapper				accountMapper;
	
	public void login(LoginFormDto dto, HttpSession session) throws BaseException {
		try {
			AccountVO accountVO = accountMapper.selectAccountByUsername(dto.getUsername());
			if (accountVO != null && accountVO.getPassword().equals(dto.getPassword())) {
				dto.setSuccessLogin("Y");
				dto.setToken(TokenObject.makeToken(dto.getUsername()));
				
				dto.setReturnType(ReturnType.success);
				dto.setErrorCode("");
				
				// 로그인 완료 후 세션 관리
				session.setAttribute("Username", dto.getUsername());
				session.setAttribute("Token", dto.getToken());
				SessionObject.addSession(dto.getUsername(), session);
				TokenObject.setToken(dto.getUsername(), dto.getToken());
			} else {
				dto.setSuccessLogin("N");
				
				dto.setReturnType(ReturnType.warning);
				dto.setErrorCode("username.password.invalid");
			}
		} catch (Exception e) {
			logger.error("(errorCode)" + e.getLocalizedMessage());
			throw new BaseException(messageSource, "errorCode", null, "", e);
		}
	}
	
}
