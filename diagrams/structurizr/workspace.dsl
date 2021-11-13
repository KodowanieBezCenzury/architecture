workspace {

    model {
        user = person "User"
        anotherUser = person "Attacker"
        softwareSystem = softwareSystem "Software System"

        user -> softwareSystem "Uses"
        anotherUser -> softwareSystem "Attack"
    }

    views {
        systemContext softwareSystem "Diagram1" {
            include *
            autoLayout
        }

        theme default
    }

}