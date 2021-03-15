package lib.sys.db;


import org.springframework.data.repository.CrudRepository;

import lib.sys.bean.Library;




public interface LibRepository extends CrudRepository<Library, Long> {

public Library findByBookName(String bookName);
public Library findByAuthor(String author);

}

    
