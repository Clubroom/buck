Buck
====

# Why we forked Buck

There are a couple bugs which were fixed by the Airbnb fork of Buck: [https://github.com/airbnb/buck/pull/8](https://github.com/airbnb/buck/pull/8)

These changes were not pulled upstream into [facebook/buck](https://github.com/facebook/buck)

## How we addressed this

We forked Buck to [clubroom/buck](https://github.com/clubroom/buck) and applied the following fixes:

- Use string types for *dstSubfolderSpec* and *runOnlyForDeploymentPostprocessing*: 
	- [45c3fab8d91ec3fc9854fa424237c6f989de37fd](https://github.com/Clubroom/buck/commit/45c3fab8d91ec3fc9854fa424237c6f989de37fd)
- Use string type for *ProxyType*
	- [8fa5ae58c5df0e991d2f2e80830a73206c384bf3](https://github.com/Clubroom/buck/commit/8fa5ae58c5df0e991d2f2e80830a73206c384bf3)

For details about Buck itself, read more [here](https://github.com/facebook/buck)