package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.DomainObject;
import com.great.cms.db.entity.Question;
import com.great.cms.db.entity.QuestionType;

public interface QuestionTypeDao extends GenericDao<QuestionType, Integer> {
	
	public QuestionType findByQuestionName(String QuestionName);

}
