package com.javahello.repository;

@Repository
public class DataRepository {

    final Logger logger = LoggerFactory.getLogger(DataRepository.class);
    private HashOperations hashOperations;

    public DataRepository(RedisTemplate redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    public void create(Data data) {
        hashOperations.put("USER", data.getDataId(), data);
        logger.info(String.format("Data with ID %s saved", data.getDataId()));
    }

    public Data get(String dataId) {
        return (Data) hashOperations.get("USER", dataId);
    }

    public Map<String, Data> getAll(){
        return hashOperations.entries("USER");
    }

    public void update(Data data) {
        hashOperations.put("USER", data.getDataId(), data);
        logger.info(String.format("Data with ID %s updated", data.getDataId()));
    }

    public void delete(String dataId) {
        hashOperations.delete("USER", dataId);
        logger.info(String.format("Data with ID %s deleted", dataId));
    }
}
