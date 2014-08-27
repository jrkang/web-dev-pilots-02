package kr.kglory.tps.common.logging;

import kr.kglory.tps.model.vo.AuditLogVO;

public interface ILogging {

	public void addLog(AuditLogVO vo);
	
}
