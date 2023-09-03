# MoreCraftingTables

Mod ported from 
- [OhHowTheCraftingHasTabled](https://github.com/P3NG00/OhHowTheCraftingHasTabled)

The recipe for the vanilla Crafting Table has a second recipe that works like this 

```
{
  "type": "minecraft:crafting_shaped",
  "pattern": [
    "##",
    "##"
  ],
  "key": {
    "#": {
      "tag": "forge:planks"
    }
  },
  "result": {
    "item": "minecraft:crafting_table"
  }
}

```

I added this hoping that it will help with future compatibility issues, if you want your mod to be compatible with mine just add your "planks" tag in 
` data/forge/tags/items/ ` in your mods folder
 What exactly should be listed here?
 - Planks that are not currently available in my mod so it will output the vanilla crafting table

This mod respects the original author's license

## MIT License

Copyright (c) 2020 Bryant Finnern

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
