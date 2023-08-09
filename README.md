<p align="center">
    <img alt="Shut Up GL Error" src="https://github.com/JamCoreModding/shut-up-gl-error/blob/1.20.1/banner.png?raw=true" />
<p align="center">

<p align="center">
    <img alt="forge" height="25" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact/supported/forge_vector.svg">
    <img alt="fabric" height="25" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact/supported/fabric_vector.svg">
</p>

Fixes invalid keycodes logging obnoxious and constant messages:

```
########## GL ERROR ##########
@ Pre render
65539: Invalid key -1
```

I played on my modpack, where I have many unbound keys, for 3 hours and **4000** of these errors were logged.

## The Solution

This mod simply patches the `InputConstants#isKeyDown` method to return `false` when the keycode is `-1` or `0`. There
was never a real error going on here - not the kind you should have to worry about and definitely not the kind that
should pollute logs constantly.

