import {isFeatureEnabled as isFeatureEnabled} from "./flag.js"

export function addTodo(text, assignee) {
    const todoList = document.getElementById('todo-list');
    
    let todoListItem;
    if ( isFeatureEnabled('great-feature') ) {
        todoListItem = createSuperFancyTodoListElement(text, assignee);
    } else {
        todoListItem = createTodoListElement(text, assignee)
    }
    
    todoList.appendChild(todoListItem);
    resetFormInputs();
}

function resetFormInputs(){
    document.getElementById("todo").value = '';
    document.getElementById("assignee").value = '';
}

function createTodoListElement(text, assignee) {
    const todoListItem = document.createElement('li');
    todoListItem.innerHTML = `
            <style>
            p {
                color: white;
                background-color: blue;
                padding: 10px;
            }
            </style>
            <p>${text} 🛠 ${assignee}</p>
            `;
       return todoListItem;
}

function createSuperFancyTodoListElement(text, assignee) {
    const todoListItem = document.createElement('li');
    todoListItem.innerHTML = `
            <style>
            p {
                color: white;
                background-color: blue;
                padding: 10px;
            }
            </style>
            <p>${assignee} will be responsible for ${text}</p>
            `;
       return todoListItem;
}