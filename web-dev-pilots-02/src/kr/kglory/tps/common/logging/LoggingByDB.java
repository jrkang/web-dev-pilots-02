package kr.kglory.tps.common.logging;

import kr.kglory.tps.model.vo.AuditLogVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingByDB implements ILogging {

	private static final Logger	logger	= LoggerFactory.getLogger(LoggingByDB.class);
	
	@Override
	public void addLog(AuditLogVO vo) {
		logger.debug(vo.toString());
	}

}
