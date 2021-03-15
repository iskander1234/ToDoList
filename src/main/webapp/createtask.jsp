<h3>Add Tasks</h3>
<form asp-action="CreateTask" method="post">
    <div class="form_row">
        <label for="name1">
            Название
            <input type="text" class="form-control" name="name" id="name1" placeholder="Name">
        </label>
    </div>
    <div class="form_row">
        <label for="priority">
            Приоритет
            <select asp-for="Priority" name="priority" id="priority">
                <option value="0">Высокий</option>
                <option value="1">Средний</option>
                <option value="2">Низкий</option>
            </select>
        </label>
    </div>
    <div class="form_row">
        <div class="about">
            Описание
        </div>
        <textarea asp-for="About" type="text" name="about" id="about"></textarea>
    </div>
    <button type="submit" >Добавить</button>
</form>
