package com.openclassrooms.notes.data

object NoteData {
    private var nextId = 1

    private fun createNote(title: String, body: String): Note {
        return Note(title = title, body = body, id = nextId++)
    }

    private val lifeIsBeautiful = createNote(
        "La vie est belle",
        "La vie est belle, pleine de choses à voir et à faire. Profitez de chaque moment et ne laissez jamais personne vous dire que vous ne pouvez pas faire ce que vous voulez."
    )
    private val neverLetAnyoneTell = createNote(
        "Ne laissez personne vous dire que vous ne pouvez pas faire quelque chose.",
        "Croyez en vous et en vos capacités. Ne laissez personne vous dire que vous ne pouvez pas faire quelque chose. Suivez vos rêves et ne laissez rien vous arrêter."
    )
    private val followYourDreams = createNote(
        "Suivez vos rêves",
        "Ne laissez rien vous arrêter de suivre vos rêves. Travaillez dur et ne vous découragez jamais. Vos rêves sont à votre portée, alors n'ayez pas peur de les poursuivre."
    )
    private val beKindToOthers = createNote(
        "Soyez gentil avec les autres",
        "Le monde a besoin de plus de gentillesse. Soyez gentil avec les autres, même si ce n'est pas facile. La gentillesse peut faire une grande différence dans le monde."
    )
    private val helpOthersAlways = createNote(
        "Aidez les autres",
        "Le monde est un meilleur endroit lorsque nous travaillons ensemble. Aidez les autres, même si c'est juste un petit geste. Chaque geste compte."
    )
    private val beGratefulForWhat = createNote(
        "Soyez reconnaissant pour ce que vous avez.",
        "Il y a toujours quelqu'un qui a moins que vous. Soyez reconnaissant pour ce que vous avez, même si ce n'est pas grand-chose. La gratitude peut vous rendre heureux et épanoui."
    )
    private val liveThePresentMoment = createNote(
        "Vivez le moment présent",
        "Ne vous inquiétez pas du passé et ne vous inquiétez pas de l'avenir. Vivez le moment présent et profitez de chaque minute. Le moment présent est tout ce que vous avez."
    )
    private val takeCareOfYourself = createNote(
        "Prenez soin de vous",
        "Mangez sainement, faites de l'exercice et dormez suffisamment. Prenez soin de votre corps et de votre esprit. Vous êtes votre meilleur atout."
    )
    private val spendTimeWithLoved = createNote(
        "Passez du temps avec vos proches",
        "Ils sont les plus importants dans votre vie. Passez du temps avec vos proches et montrez-leur à quel point vous les aimez. Ils sont votre famille et vos amis."
    )
    private val laughAndHaveFun = createNote(
        "Riez et amusez-vous.",
        "La vie est trop courte pour être sérieuse tout le temps. Riez et amusez-vous. Passez du temps à faire les choses que vous aimez."
    )
    val Notes = mutableListOf(
        lifeIsBeautiful,
        neverLetAnyoneTell,
        followYourDreams,
        beKindToOthers,
        helpOthersAlways,
        beGratefulForWhat,
        liveThePresentMoment,
        takeCareOfYourself,
        spendTimeWithLoved,
        laughAndHaveFun
    )
}