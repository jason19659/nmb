/**
 * 
 */
package pw.jason19659.nmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pw.jason19659.nmb.dao.SectionMapper;
import pw.jason19659.nmb.model.Section;
import pw.jason19659.nmb.service.SectionService;

/**
 * @author <a href="mailto:ziywang@cisco.com">Jason</a>
 *
 * pw.jason19659.nmb.service.impl
 *
 * 2016年1月15日
 */
@Service
public class SectionServiceImpl implements SectionService {
	
	@Autowired
	private SectionMapper SectionMapper;
	/* 
	 * @see pw.jason19659.nmb.service.SectionService#deleteByPrimaryKey(java.lang.String)
	 */
	public int deleteByPrimaryKey(Integer id) {
		return SectionMapper.deleteByPrimaryKey(id);
	}

	/* 
	 * @see pw.jason19659.nmb.service.SectionService#insert(pw.jason19659.nmb.model.Section)
	 */
	public int insert(Section record) {
		return SectionMapper.insert(record);
	}

	/* 
	 * @see pw.jason19659.nmb.service.SectionService#insertSelective(pw.jason19659.nmb.model.Section)
	 */
	public int insertSelective(Section record) {
		return SectionMapper.insertSelective(record);
	}

	/* 
	 * @see pw.jason19659.nmb.service.SectionService#selectByPrimaryKey(java.lang.String)
	 */
	public Section selectByPrimaryKey(Integer id) {
		return SectionMapper.selectByPrimaryKey(id);
	}


	/* 
	 * @see pw.jason19659.nmb.service.SectionService#updateByPrimaryKeySelective(pw.jason19659.nmb.model.Section)
	 */
	public int updateByPrimaryKeySelective(Section record) {
		return SectionMapper.updateByPrimaryKey(record);
	}

	/* 
	 * @see pw.jason19659.nmb.service.SectionService#updateByPrimaryKey(pw.jason19659.nmb.model.Section)
	 */
	public int updateByPrimaryKey(Section record) {
		return SectionMapper.updateByPrimaryKey(record);
	}
	
	
	public List<Section> selectAll() {
		return SectionMapper.selectAll();
	}

}
