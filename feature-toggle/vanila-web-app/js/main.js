import {addTodo as addTodo} from "./app.js"

document.addEventListener("DOMContentLoaded", (event) => {
    
    const form  = document.querySelector("form");
    form.onsubmit = (event) => {
        event.preventDefault();

        const todo = document.getElementById("todo");
        const assignee = document.getElementById("assignee");
        addTodo(todo.value, assignee.value);
    }
});