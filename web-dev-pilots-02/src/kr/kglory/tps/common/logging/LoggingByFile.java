package kr.kglory.tps.common.logging;

import kr.kglory.tps.model.vo.AuditLogVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingByFile implements ILogging {

	private static final Logger	logger	= LoggerFactory.getLogger(LoggingByFile.class);
	
	@Override
	public void addLog(AuditLogVO vo) {
		// TODO Auto-generated method stub
		logger.debug(vo.toString());
	}

}
