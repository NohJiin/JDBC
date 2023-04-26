use shop9

db.memo.find({})

db.memo.count()

// 1. name이 Tom이고 office가 seoul인 documents의 phone은?
db.memo.find({"name": "Tom", "office": "seoul"},{"_id": 0, "phone":1})
// 2. age가 10이거나 office가 Wordware인 documents의 개수는?
// {$or: {키:값, 키:값}}
db.memo.find({$or : [{"age": 10, "office": "Wordware"}]}, {}).count()
// 3. age가 10이거나 office가 Wordware인 documents의 name은?
db.memo.find({$or : [{"age": 10, "office": "Wordware"}]}, {"_id": 0, "name":1})
// 4. office가 busan인 documents중 _id, age빼고 모두 출력
db.memo.find({"office": "busan"}, {"_id": 0, "age": 0})
// 5. office가 busan이 아닌 documents 중 office, phone은?
db.memo.find({"office": {$not: /busan/}}, {"_id": 0, "office":1, "phone":1})
// 6. office가 seoul인 사람의 phone, name만 출력(수를 2개만 출력)
db.memo.find({"office": "seoul"}, {"phone": 1, "name": 1}).limit(2)

db.memo.find({"office": "Wordware"})

db.memo.updateMany({"office": "seoul"}, {$set: {phone: '999'}})

db.memo.find({"office": "seoul"}, {phone: 1})

// 조건 없이 줌으로 모두 삭제
db.memo.deleteMany({})

db.memo.find({}).count()