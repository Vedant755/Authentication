const express = require("express");
const app = express();

const userRouter = require("./routes/userRoutes"); 
const dotenv = require("dotenv");
const cors = require("cors");

dotenv.config();

const mongoose = require("mongoose");

app.use(express.json());

app.use(cors());

app.use("/users", userRouter);



const PORT =  9090;

mongoose.connect('mongodb+srv://admin:admin@cluster0.xpzz8wo.mongodb.net/?retryWrites=true&w=majority')
.then(()=>{
    app.listen(PORT, ()=>{
        console.log("Server started on port no. " + PORT);
    });
})
.catch((error)=>{
    console.log(error);
})


