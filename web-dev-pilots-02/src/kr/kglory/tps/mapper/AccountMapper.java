package kr.kglory.tps.mapper;

import java.util.List;

import kr.kglory.tps.model.vo.AccountVO;

public interface AccountMapper {
	
	AccountVO selectAccountByUsername(String userid);
	
	List<AccountVO> selectAccounts();
}
