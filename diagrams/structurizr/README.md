# Structurizr
* Official site: [https://structurizr.com/](https://structurizr.com/)
* Online demo: [https://structurizr.com/dsl](https://structurizr.com/dsl)
* Examples : [https://github.com/structurizr/dsl/tree/master/examples](https://github.com/structurizr/dsl/tree/master/examples)

## [Installation](https://github.com/structurizr/cli/blob/master/docs/getting-started.md)

<details>
<summary>I could use some help...</summary>

```bash
#> lite
touch workspace.dsl

docker pull structurizr/lite
docker run -it --rm -p 8080:8080 -v $PWD:/usr/local/structurizr structurizr/lite
open http://localhost:8080/workspace/diagrams
#> cli
docker pull structurizr/cli:latest
docker run -it --rm -v $PWD:/usr/local/structurizr structurizr/cli
# using brew
brew install structurizr-cli
```

</details>

## Examples
* [C4 level 1](c4-level1.dsl)
* [C4 level 2](c4-level2.dsl)
* [C4 level 3](c4-level3.dsl)
