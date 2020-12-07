package com.joshua.pim.Repository;

import com.joshua.pim.Model.History;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository  extends CrudRepository <History, Long> {
    Iterable<History> findByHistoryID(Long historyID);
}
