export function addTodo(text, assignee, status) {
    const todoList = document.getElementById('todo-list');
    todoList.appendChild(createTodoListElement(text, assignee, status));
    resetFormText();
}

function resetFormText(){
    document.getElementById("todo").value = '';
    document.getElementById("assignee").value = '';
}

function createTodoListElement(text, assignee, status) {
    const todoListItem = document.createElement('li');
    todoListItem.innerHTML = `
            <style>
            p {
                color: white;
                background-color: #166;
                padding: 10px;
            }
            </style>
            <p>${text} 🛠 ${assignee}</p>
            `;
       return todoListItem;
}
