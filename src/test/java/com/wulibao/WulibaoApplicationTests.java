package com.wulibao;

import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class WulibaoApplicationTests {
    
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    
    /**
     * Key相关操作
     */
    @Test
    public void redisKey() {
        // 清空当前数据库
        Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection().flushDb();
        // Type:返回 key 所储存的值的类型。
        redisTemplate.opsForValue().set("one", "one");
        DataType type = redisTemplate.type("one");
        // pExpireAt:设置 key 过期时间的时间戳(unix timestamp) 以毫秒计
        redisTemplate.opsForValue().set("two", "two");
        Boolean expireAt = redisTemplate.expireAt("two", new Date(1615531251000L));
        // rename:修改 key 的名称
        redisTemplate.rename("two", "three");
        // persist:移除 key 的过期时间，key 将持久保持。
        Boolean persist = redisTemplate.persist("three");
        // move:将当前数据库的 key 移动到给定的数据库 db 当中。
        Boolean move = redisTemplate.move("one", 14);
        // randomKey:从当前数据库中随机返回一个 key 。
        String randomKey = redisTemplate.randomKey();
        // dump:序列化给定 key ，并返回被序列化的值。
        byte[] dump = redisTemplate.dump("three");
        // TTL:以秒为单位，返回给定 key 的剩余生存时间(TTL, time to live)。
        Long ttl = redisTemplate.getExpire("three");
        // expire:seconds 为给定 key 设置过期时间。
        Boolean expire = redisTemplate.expire("one", 3600, TimeUnit.HOURS);
        // del:该命令用于在 key 存在是删除 key。
        Boolean delete = redisTemplate.delete("one");
        // renameNX:仅当 newKey 不存在时，将 key 改名为 newKey 。
        Boolean renameIfAbsent = redisTemplate.renameIfAbsent("three", "four");
        // exists:检查给定 key 是否存在。
        Boolean hasKey = redisTemplate.hasKey("one");
        // keys:查找所有符合给定模式( pattern)的 key 。
        Set<String> keys = redisTemplate.keys("*");
    }
    
    /**
     * String数据结构操作
     */
    @Test
    public void redisString() {
        // 清空当前数据库
        Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection().flushDb();
        // setNX:只有在 key 不存在时设置 key 的值。
        Boolean setIfAbsent = redisTemplate.opsForValue().setIfAbsent("one", "one");
        // getRange:返回 key 中字符串值的子字符
        String getRange = redisTemplate.opsForValue().get("one", 0, 1);
        // mSet:同时设置一个或多个 key-value 对。
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("two", "two");
        hashMap.put("three", "three");
        redisTemplate.opsForValue().multiSet(hashMap);
        // getSet:将给定 key 的值设为 value ，并返回 key 的旧值(old value)。
        Object andSet = redisTemplate.opsForValue().getAndSet("two", "too");
        // mGet:获取所有(一个或多个)给定 key 的值。
        List<Object> multiGet = redisTemplate.opsForValue().multiGet(Arrays.asList("one", "two"));
        // setEX:将值 value 关联到 key ，并将 key 的过期时间设为 seconds (以秒为单位)。
        redisTemplate.opsForValue().set("four", "1000", 3600, TimeUnit.HOURS);
        // mSetNX:同时设置一个或多个 key-value 对，当且仅当所有给定 key 都不存在。
        Boolean mSetNX = redisTemplate.opsForValue().multiSetIfAbsent(hashMap);
        // !!!以下为Redis自带的计算方法，因为项目序列化原因，导致Redis中存入得均为jsonString,不是num类型，所以无法进行计算------------
        // decr:将 key 中储存的数字值减一。
        Long decr = redisTemplate.opsForValue().decrement("four");
        // decrBy:key 所储存的值减去给定的减量值（decrement） 。
        Long decrBy = redisTemplate.opsForValue().decrement("four", 10);
        // inCr:将 key 中储存的数字值增一。
        Long inCr = redisTemplate.opsForValue().increment("four");
        // inCrBy:将 key 所储存的值加上给定的增量值（increment） 。
        Long inCrBy = redisTemplate.opsForValue().increment("four", 5);
        // inCrByFloat:将 key 所储存的值加上给定的浮点增量值（increment） 。
        Double inCrByFloat = redisTemplate.opsForValue().increment("four", 5.5);
        // !!!以下为Redis字符串使用，因为项目序列化原因，导致Redis中存入得均为jsonString,所以String操作达不到预期效果----------------
        // strLen:返回 key 所储存的字符串值的长度。
        Long strLen = redisTemplate.opsForValue().size("four");
        // setRange:用 value 参数覆写给定 key 所储存的字符串值，从偏移量 offset 开始。
        redisTemplate.opsForValue().set("one", "haha", 2);
        // append:如果 key 已经存在并且是一个字符串， APPEND 命令将 value 追加到 key 原来的值的末尾。
        Integer append = redisTemplate.opsForValue().append("one", "hehe");
    }
    
    /**
     * Hash数据结构操作
     */
    @Test
    public void redisHash() {
        // 清空当前数据库
        Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection().flushDb();
        // hSet:将哈希表 key 中的字段 field 的值设为 value 。
        redisTemplate.opsForHash().put("fruit", "apple", 15);
        // hGet:获取存储在哈希表中指定字段的值
        Object hGet = redisTemplate.opsForHash().get("fruit", "apple");
        // hMSet:同时将多个 field-value (域-值)对设置到哈希表 key 中。
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("grape", 12);
        hashMap.put("pear", 20);
        redisTemplate.opsForHash().putAll("fruit", hashMap);
        // hMGet:获取所有给定字段的值
        List<Object> hMGet = redisTemplate.opsForHash().multiGet("fruit", Arrays.asList("apple", "pear"));
        // hExists:查看哈希表 key 中，指定的字段是否存在。
        Boolean hExists = redisTemplate.opsForHash().hasKey("fruit", "apple");
        // hGetAll:获取在哈希表中指定 key 的所有字段和值
        Map<Object, Object> hGetAll = redisTemplate.opsForHash().entries("fruit");
        // hSetNX:只有在字段 field 不存在时，设置哈希表字段的值。
        Boolean hSetNX = redisTemplate.opsForHash().putIfAbsent("fruit", "apple", 30);
        // hLen:获取哈希表中字段的数量
        Long hLen = redisTemplate.opsForHash().size("fruit");
        // hDel:删除一个或多个哈希表字段
        Long hDel = redisTemplate.opsForHash().delete("fruit", "pear");
        // hKeys:获取所有哈希表中的字段
        Set<Object> hKeys = redisTemplate.opsForHash().keys("fruit");
        // hVals:获取哈希表中所有值
        List<Object> hVals = redisTemplate.opsForHash().values("fruit");
    }
    
    /**
     * List数据结构操作
     */
    @Test
    public void redisList() {
        // 清空当前数据库
        Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection().flushDb();
        // lPush:将一个或多个值插入到列表头部（最左）
        Long lPush = redisTemplate.opsForList().leftPush("color", "red");
        // rPush:将一个或多个值插入到列表头部（最右）
        Long rPush = redisTemplate.opsForList().rightPush("color", "blue");
        // lPushX:将一个值插入到已存在的列表头部(最左)
        Long lPushX = redisTemplate.opsForList().leftPushAll("color", "white", "black");
        // rPushX:将一个值插入到已存在的列表尾部(最右)
        Long rPushX = redisTemplate.opsForList().rightPushAll("color", "green", "yellow");
        // lPop:移出并获取列表第一个元素（最左）
        Object lPop = redisTemplate.opsForList().leftPop("color");
        // rPop:移除并获取列表最后一个元素（最右）
        Object rPop = redisTemplate.opsForList().rightPop("color");
        // bLPop:移出并获取列表的第一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
        Object bLPop = redisTemplate.opsForList().leftPop("color", 10, TimeUnit.SECONDS);
        // bRPop:移出并获取列表的最后一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
        Object bRPop = redisTemplate.opsForList().rightPop("color", 10, TimeUnit.SECONDS);
        // rPopLPush:移除列表的最后一个元素，并将该元素添加到另一个列表并返回
        Object rPopLPush = redisTemplate.opsForList().rightPopAndLeftPush("color", "colorCopy");
        // bRPopLPush:从列表中弹出一个值，将弹出的元素插入到另外一个列表中并返回它； 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
        Object bRPopLPush = redisTemplate.opsForList().rightPopAndLeftPush("color", "colorCopy", 10, TimeUnit.SECONDS);
        // 重新增加测试数据
        redisTemplate.opsForList().rightPushAll("color", "red", "white", "green", "yellow");
        // lIndex:通过索引获取列表中的元素
        Object lIndex = redisTemplate.opsForList().index("color", 1);
        // lRange:获取列表指定范围内的元素
        List<Object> lRange = redisTemplate.opsForList().range("color", 0, -1);
        // lInsert:在列表的元素前或者后插入元素
        redisTemplate.opsForList().leftPush("color", "white", "blue");
        redisTemplate.opsForList().rightPush("color", "green", "black");
        // lSet:通过索引设置列表元素的值
        redisTemplate.opsForList().set("color", 0, "pink");
        // lRem:移除列表元素
        Long remove = redisTemplate.opsForList().remove("color", 1, "green");
        // lLen:获取列表长度
        Long lLen = redisTemplate.opsForList().size("color");
        // lTrim:对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除。
        redisTemplate.opsForList().trim("color", 0, -1);
    }
    
    /**
     * Set数据结构操作
     */
    @Test
    public void redisSet() {
        // 清空当前数据库
        Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection().flushDb();
        // sAdd:向集合添加一个或多个成员
        Long sAdd = redisTemplate.opsForSet().add("animal", "dog", "cat", "bird", "fish");
        // sRem:移除集合中一个或多个成员
        Long sRem = redisTemplate.opsForSet().remove("animal", "bird");
        // sMembers:返回集合中的所有成员
        Set<Object> sMembers = redisTemplate.opsForSet().members("animal");
        // sIsMember:判断 member 元素是否是集合 key 的成员
        Boolean sIsMember = redisTemplate.opsForSet().isMember("animal", "dog");
        // sCard:获取集合的成员数
        Long sCard = redisTemplate.opsForSet().size("animal");
        // sScan:迭代集合中的元素
        Cursor<Object> sScan =
            redisTemplate.opsForSet().scan("animal", ScanOptions.scanOptions().count(10).match("*").build());
        // sRandMember:返回集合中一个或多个随机数
        Object sRandMember = redisTemplate.opsForSet().randomMember("animal");
        // sPop:移除并返回集合中的一个随机元素
        Object sPop = redisTemplate.opsForSet().pop("animal");
        // sMove:将 member 元素从 source 集合移动到 destination 集合
        redisTemplate.opsForSet().add("foot", "fish", "bead");
        Boolean sMove = redisTemplate.opsForSet().move("animal", "dog", "foot");
        // sDiff:返回给定所有集合的差集
        Set<Object> sDiff = redisTemplate.opsForSet().difference("animal", "foot");
        // sInter:返回给定所有集合的交集
        Set<Object> sInter = redisTemplate.opsForSet().intersect("animal", "foot");
        // sUnion:返回所有给定集合的并集
        Set<Object> sUnion = redisTemplate.opsForSet().union("animal", "foot");
        // sDiffStore:返回给定所有集合的差集并存储在 destination 中
        Long sDiffStore = redisTemplate.opsForSet().differenceAndStore("foot", "animal", "result");
        // sInterStore:返回给定所有集合的交集并存储在 destination 中
        Long sInterStore = redisTemplate.opsForSet().intersectAndStore("foot", "animal", "result");
        // sUnionStore:所有给定集合的并集存储在 destination 集合中
        Long sUnionStore = redisTemplate.opsForSet().unionAndStore("foot", "animal", "result");
    }
    
    /**
     * ZSet数据结构操作
     */
    @Test
    public void redisZSet() {
        
    }
    
    /**
     * HyperLogLog(基数)数据结构操作
     */
    @Test
    public void redisHyperLogLog() {
        // 清空当前数据库
        Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection().flushDb();
        // pFAdd:添加指定元素到 HyperLogLog 中。
        Long pFAdd = redisTemplate.opsForHyperLogLog().add("num:one", "one", "two", "tree", "four");
        // pFCount:返回给定 HyperLogLog 的基数估算值。
        Long pFCount = redisTemplate.opsForHyperLogLog().size("num:one");
        // pGMerge:将多个 HyperLogLog 合并为一个 HyperLogLog
        Long pFAddMore = redisTemplate.opsForHyperLogLog().add("num:two", "four", "five", "six");
        Long pGMerge = redisTemplate.opsForHyperLogLog().union("num:one", "num:two");
    }
    
    /**
     * Geo(地理位置)数据结构操作
     */
    @Test
    public void redisGeo() {
        // 清空当前数据库
        Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection().flushDb();
        // geoAdd:将指定的地理空间位置（纬度、经度、名称）添加到指定的key中
        redisTemplate.opsForGeo().add("city", new Point(116.405285, 39.904989), "beijing");
        redisTemplate.opsForGeo().add("city", new Point(120.21201, 30.2084), "hangzhou");
        redisTemplate.opsForGeo().add("city", new Point(121.48941, 31.40527), "shanghai");
        redisTemplate.opsForGeo().add("city", new Point(113.27324, 23.15792), "guangzhou");
        // geoHash:返回一个或多个位置元素的 Geohash 表示
        List<String> geoHash = redisTemplate.opsForGeo().hash("city", "beijing");
        // geoPos:从key里返回所有给定位置元素的位置（经度和纬度）
        List<Point> geoPos = redisTemplate.opsForGeo().position("city", "hangzhou");
        // geoDist:返回两个给定位置之间的距离
        Distance geoDist = redisTemplate.opsForGeo().distance("city", "beijing", "hangzhou");
        // geoRadius:以给定的经纬度为中心， 找出某一半径内的元素
        Distance distance = new Distance(200, RedisGeoCommands.DistanceUnit.KILOMETERS);
        GeoResults<RedisGeoCommands.GeoLocation<Object>> geoRadius =
            redisTemplate.opsForGeo().radius("city", new Circle(new Point(120.21201, 30.2084), distance));
        // geoRadiusByMember:找出位于指定范围内的元素，中心点是由给定的位置元素决定
        GeoResults<RedisGeoCommands.GeoLocation<Object>> geoRadiusByMember =
            redisTemplate.opsForGeo().radius("city", "hangzhou", distance);
    }
    
    /**
     * Bit(位图)数据结构操作
     */
    @Test
    public void redisBit() {
        // 清空当前数据库
        Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection().flushDb();
        // setBit:对 key 所储存的字符串值，设置或清除指定偏移量上的位(bit)。
        redisTemplate.opsForValue().setBit("bit", 0, true);
        redisTemplate.opsForValue().setBit("bit", 1, false);
        redisTemplate.opsForValue().setBit("bit", 2, true);
        // getBit:对 key 所储存的字符串值，获取指定偏移量上的位(bit)。
        Boolean zero = redisTemplate.opsForValue().getBit("bit", 0);
        Boolean one = redisTemplate.opsForValue().getBit("bit", 1);
    }
    
}
