use shop5

db.memo.find({})

// select * from memo

db.createUser({
    user : "winner",
    pwd : "1234",
    roles : ["readWrite", "dbAdmin"]
})