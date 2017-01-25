package tnmk.el.service.historyevent;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tnmk.el.service.historyevent.model.HistoryEvent;

/**
 * Database for ancient countries:
 * http://www.opengeocode.org/download.php#cities (*)
 * http://ec2-54-201-183-195.us-west-2.compute.amazonaws.com/cow/
 * http://ancientlocations.net/Default.aspx?p=i
 * <p>
 * http://www.worldcitiesdatabase.com/world-cities.aspx
 * http://www.geodatasource.com/world-cities-database/free
 * <p>
 * https://raw.githubusercontent.com/David-Haim/CountriesToCitiesJSON/master/countriesToCities.json
 * http://stackoverflow.com/questions/1794833/list-of-cities-by-country
 *
 * @author khoi.tran on 9/20/16.
 */
@Repository
public interface HistoryEventRepository extends MongoRepository<HistoryEvent, String> {
}
