use shop10

db.memo.find({})    // 전체 검색

db.memo.count({})    // document 개수

db.memo.insertOne({
    "name": "apple",
    "age": 100
})

db.memo.find({})

db.memo.find({"name": "apple"})

db.memo.find({"age": 100})

db.createCollection("member")

db.member.stats()

db.member.insertOne({
    "name": "hong2",
    "age": 100,
    "tel": "010"
})

db.member.find({})

show collections    // 전체 콜렉션 보여줌

db.createCollection("bbs")

db.bbs.insertOne({
    "title": "win"
})

db.bbs.find({})

db.dropDatabase()    // 데이터베이스 자체가 지워짐

show databases

use shop5

db.memo.find({})

db.createCollection("member")

db.member.insertOne({
    "id": "hong",
    "pw": "1234", 
    "name": "honggildong",
    "tel": "011"
})

db.member.find({})

db.member.insertOne({
    "id": "kim",
    "pw": "1234", 
    "name": "kimdong",
    "tel": "012"
})

db.member.insertOne({
    "id": "park",
    "pw": "1234", 
    "name": "parkdong",
    "tel": "013"
})

//db.member.insertMany([{"id": "kim","pw": "1234","name": "kimhong","tel": "012"},
//                       {"id": "park","pw": "1234","name": "parkdong","tel": "013"}])

db.member.find({})

db.member.drop()    // member collection 삭제

db.dropDatabase()    // shop5 database 삭제

show databases