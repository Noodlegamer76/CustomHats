# CustomHats

this is a quick custom hats plugin i made for my smp, its not very admin friendly but i made it so it works well with your players

features:
create a custom hat that works with a resource pack
you can enchant your hat with any helmet enchantments
you can right click or place it in your helmet slot to equip
rarity: every hat will have one of 5 rarities
wandering trader: every wandering trader will spawn with a random hat that costs 1 diamond helmet + 10 random hardcoded second ingrediants
every hat will have the same armor as a diamond helmet

limits:
THERE ARE NO CONFIG OPTIONS OTHER THEN THE LIST OF HATS YOU HAVE
this plugin will see any knowledge boox with custom model data as a hat
this plugin will convert any diamond helmet with custom model data into a knowledge book with the same nbt data

commands:
/hats: opens a GUI showing your hats
/hats reload: reload config
/hats rhat: generate a random hat
 
creating a hat:

/hats create <ID> <Rarity> <Name>
ID: needs to be a number, and will be used as the custom model data
Rarity: read features above, the rarities in order are "common", "uncommon", "rare", "uber", "legendary" and are case sensitive
Name: Can be as long as you want

if you mess up anything in that command, eg. putting a letter in the id, or mispelling a rarity name, you will have to change it in the config
if you want to remove a hat you also need to go into the config
