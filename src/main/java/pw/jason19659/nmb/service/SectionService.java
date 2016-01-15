package pw.jason19659.nmb.service;

import pw.jason19659.nmb.model.Section;

public interface SectionService {
    int deleteByPrimaryKey(Integer id);

    int insert(Section record);

    int insertSelective(Section record);

    Section selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Section record);

    int updateByPrimaryKey(Section record);
}