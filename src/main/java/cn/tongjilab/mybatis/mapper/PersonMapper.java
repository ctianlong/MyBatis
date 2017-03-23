package cn.tongjilab.mybatis.mapper;

import cn.tongjilab.mybatis.entity.Person;

public interface PersonMapper {
	
	Person selectPerson(int id);
	 
    Person selectPersonByName(String name);
 
    void insertPerson(Person person);
 
    void updatePerson(Person person);
 
    void deletePerson(Person person);

}
